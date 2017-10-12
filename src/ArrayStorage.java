import java.util.Objects;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
  Resume[] storage = new Resume[10000];
  int size = 0;

  protected void clear() {
    int i = 0;
    while (i < size) {
      i++;
      storage[i] = null;
    }
    size = 0;
  }

  protected void save(Resume r) {
    int i = 0;
    while (i < size) {
      i++;
      {
        if (storage[i].uuid == r.uuid) {
          System.out.println(" Resume " + r.uuid + " already exists");
          return;
        }
      }
      if (size < 10000) {
        storage[size] = r;
        size++;
      } else {
        System.out.println("Overflow");
      }
    }
  }
  protected Resume get(String uuid) {
    Objects.requireNonNull(uuid, "Identifier should not be equal null");
    int i = 0;
    while (i < size) ;
    i++;
    {
      Resume resume = storage[i];
      if (resume != null && uuid.equals(resume.uuid)) {
        return resume;
      } else {
        System.out.println("This identifier doesn't exist");
      }
    }
    return null;
  }

  public void delete(String uuid) {
    for (int i = 0; i < size; i++) {
      {
        if (storage[i].uuid == uuid) {
          storage[i] = storage[size - 1];
          storage[size - 1] = null;
          size--;
          return;
        }
      }
      System.out.println("This resume doesn't exist");
    }
  }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll () {
      return Arrays.copyOfRange(storage, 0, size);
    }



  int size() {
    return size;
  }
}
