#include <bits/stdc++.h>
using namespace std;
struct Tag {
  Tag(int id_, int size_) : id(id_), size(size_) {}
  int id;
  int size;
};
class MemoryManager {
 public:
  MemoryManager(int size) : m_slots(1, Tag(0, size)), m_id(1) {}
  void alloc(int size);
  void erase(int id);
  void defragment();
  void print() const;

 private:
  list<Tag> m_slots;
  int m_id;
};
void MemoryManager::alloc(int request) {
  list<Tag>::iterator it;
  for (it = m_slots.begin(); it != m_slots.end(); ++it) {
    if (it->id == 0 && it->size >= request) {
      if (it->size == request) {
        it->id = m_id;
      } else {
        it->size -= request;
        m_slots.insert(it, Tag(m_id, request));
      }
      break;
    }
  }
  if (it != m_slots.end()) {
    cout << m_id << endl;
    m_id++;
  } else {
    cout << "NULL" << endl;
  }
}
void MemoryManager::erase(int id) {
  if (id == 0) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    return;
  }
  list<Tag>::iterator it;
  for (it = m_slots.begin(); it != m_slots.end(); ++it) {
    if (it->id == id) {
      it->id = 0;
      list<Tag>::iterator itNext = it;
      itNext++;
      if (itNext != m_slots.end() && itNext->id == 0) {
        it->size += itNext->size;
        m_slots.erase(itNext);
      }
      if (it != m_slots.begin()) {
        list<Tag>::iterator itPrev = it;
        itPrev--;
        if (itPrev->id == 0) {
          it->size += itPrev->size;
          m_slots.erase(itPrev);
        }
      }
      break;
    }
  }
  if (it == m_slots.end()) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
  }
}
void MemoryManager::defragment() {
  for (list<Tag>::iterator it = m_slots.begin(); it != m_slots.end(); ++it) {
    if (it->id == 0) {
      list<Tag>::iterator itNext = it;
      itNext++;
      while (itNext != m_slots.end() && itNext->id == 0) {
        it->size += itNext->size;
        m_slots.erase(itNext);
        itNext = it;
        itNext++;
      }
      if (itNext != m_slots.end() && itNext->id > 0) {
        swap(it->id, itNext->id);
        swap(it->size, itNext->size);
      }
    }
  }
}
void MemoryManager::print() const {
  cout << "==============" << endl;
  for (list<Tag>::const_iterator it = m_slots.begin(); it != m_slots.end();
       ++it) {
    cout << "(" << it->id << " " << it->size << ")" << endl;
  }
  cout << "==============" << endl;
}
int main() {
  int t, m;
  cin >> t >> m;
  MemoryManager mm(m);
  for (int i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int size;
      cin >> size;
      mm.alloc(size);
    } else if (s == "erase") {
      int id;
      cin >> id;
      mm.erase(id);
    } else {
      mm.defragment();
    }
  }
  return 0;
}
