#include <bits/stdc++.h>
using namespace std;
bool canUse[211];
struct Block {
  int first, last, id;
} blocks[111];
bool operator<(const Block& a, const Block& b) { return a.first < b.first; }
int nBlock, q, avail;
int main() {
  ios ::sync_with_stdio(false);
  while (cin >> q >> avail) {
    memset(canUse, false, sizeof canUse);
    for (int i = (1), _b = (avail); i <= _b; i++) canUse[i] = true;
    nBlock = 0;
    int lastId = 0;
    while (q--) {
      string typ;
      cin >> typ;
      if (typ == "alloc") {
        int u;
        cin >> u;
        int id = -1;
        for (int i = (1), _b = (avail - u + 1); i <= _b; i++) {
          bool allCanUse = true;
          for (int j = (i), _b = (i + u - 1); j <= _b; j++)
            allCanUse = allCanUse && canUse[j];
          if (allCanUse) {
            ++nBlock;
            id = ++lastId;
            blocks[nBlock].first = i;
            blocks[nBlock].last = i + u - 1;
            blocks[nBlock].id = id;
            for (int j = (i), _b = (i + u - 1); j <= _b; j++) canUse[j] = false;
            break;
          }
        }
        if (id < 0)
          cout << "NULL\n";
        else
          cout << id << '\n';
      } else if (typ == "erase") {
        int u;
        cin >> u;
        bool found = false;
        for (int i = (1), _b = (nBlock); i <= _b; i++)
          if (blocks[i].id == u) {
            for (int j = (blocks[i].first), _b = (blocks[i].last); j <= _b; j++)
              canUse[j] = true;
            found = true;
            swap(blocks[i], blocks[nBlock]);
            --nBlock;
            break;
          }
        if (!found) cout << "ILLEGAL_ERASE_ARGUMENT\n";
      } else {
        sort(blocks + 1, blocks + nBlock + 1);
        int last = 0;
        for (int i = (1), _b = (nBlock); i <= _b; i++) {
          int len = blocks[i].last - blocks[i].first;
          blocks[i].first = last + 1;
          blocks[i].last = blocks[i].first + len;
          last = blocks[i].last;
        }
        for (int j = (1), _b = (last); j <= _b; j++) canUse[j] = false;
        for (int j = (last + 1), _b = (avail); j <= _b; j++) canUse[j] = true;
      }
    }
  }
  return 0;
}
