#include <bits/stdc++.h>
using namespace std;
struct block {
  long long start, size, id;
  bool free;
  block(long long s, long long sz, bool f, long long i = -1) {
    start = s;
    size = sz;
    free = f;
    id = i;
  }
};
long long alloc = 0, id = 1;
bool allocate(vector<block>& blocks, long long size) {
  for (long long i = 0; i < blocks.size(); ++i) {
    if (blocks[i].free && blocks[i].size >= size) {
      long long sz = blocks[i].size;
      block b(0, size, false, id++);
      if (i > 0) {
        b.start = blocks[i - 1].start + blocks[i - 1].size;
      }
      blocks.erase(blocks.begin() + i);
      blocks.insert(blocks.begin() + i, b);
      blocks.insert(blocks.begin() + i + 1,
                    block(b.start + b.size, sz - size, true));
      alloc += size;
      return true;
    }
  }
  return false;
}
bool erase(vector<block>& blocks, long long id) {
  for (long long i = 0; i < blocks.size(); ++i) {
    if (!blocks[i].free && blocks[i].id == id) {
      alloc -= blocks[i].size;
      long long l = i - 1, r = i + 1, size = blocks[i].size;
      while (l >= 0 && blocks[l].free) {
        size += blocks[l].size;
        l--;
      }
      while (r < blocks.size() && blocks[r].free) {
        size += blocks[r].size;
        r++;
      }
      blocks.erase(blocks.begin() + l + 1, blocks.begin() + r);
      block b(0, size, true);
      if (l > 0) {
        b.start = blocks[l - 1].start + blocks[l - 1].size;
      }
      blocks.insert(blocks.begin() + l + 1, b);
      return true;
    }
  }
  return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t, m;
  cin >> t >> m;
  block b(0, m, true);
  vector<block> blocks;
  blocks.push_back(b);
  while (t--) {
    string s;
    long long x;
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      if (allocate(blocks, x)) {
        cout << id - 1 << "\n";
      } else {
        cout << "NULL\n";
      }
    } else if (s == "erase") {
      cin >> x;
      if (!erase(blocks, x)) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      }
    } else {
      long long j = 0;
      for (long long i = 0; i < blocks.size(); ++i) {
        if (!blocks[i].free) {
          blocks[j] = blocks[i];
          if (j == 0) {
            blocks[j].start = 0;
          } else {
            blocks[j].start = blocks[j - 1].start + blocks[j - 1].size;
          }
          j++;
        }
      }
      blocks.erase(blocks.begin() + j, blocks.end());
      blocks.push_back(block(alloc, m - alloc, true));
    }
  }
  return 0;
}
