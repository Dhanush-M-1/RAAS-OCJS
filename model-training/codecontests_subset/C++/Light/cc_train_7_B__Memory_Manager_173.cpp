#include <bits/stdc++.h>
using namespace std;
struct data {
  long long v;
  bool operator<(const data& cmp) const { return v < cmp.v; }
};
long long t, m, alc(long long), ID;
deque<long long> memory;
char s[50];
bool Erase(long long);
void Defrag();
int main() {
  scanf("%I64d%I64d", &t, &m);
  memory.resize(m);
  for (long long i = 0, id, sz; i < t; i++) {
    scanf("%s", s);
    if (!strcmp(s, "alloc")) {
      scanf("%I64d", &sz);
      long long c = alc(sz);
      if (c == -1)
        puts("NULL");
      else
        printf("%I64d\n", c);
    } else if (!strcmp(s, "erase")) {
      scanf("%I64d", &id);
      if (id < 1 || !Erase(id)) puts("ILLEGAL_ERASE_ARGUMENT");
    } else
      Defrag();
  }
}
void Defrag() {
  long long z = 0;
  for (long long i = 0; i < memory.size();)
    if (!memory[i])
      memory.erase(memory.begin() + i), z++;
    else
      i++;
  while (z--) memory.push_back(0);
}
long long alc(long long sz) {
  for (long long i = 0; i <= m - sz; i++)
    for (long long j = i; j < i + sz; j++) {
      if (memory[j]) break;
      if (j == i + sz - 1) {
        ID++;
        fill(memory.begin() + i, memory.begin() + i + sz, ID);
        return ID;
      }
    }
  return -1;
}
bool Erase(long long id) {
  bool found = false;
  for (long long i = 0; i < m; i++)
    if (memory[i] == id) memory[i] = 0, found = true;
  return found;
}
