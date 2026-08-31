#include <bits/stdc++.h>
using namespace std;
int memory[100];
int m, n;
void defrag() {
  for (int i = 0, j = 0; i < m; i++) {
    while (j < i && memory[j] != 0) j++;
    if (memory[j] != 0) continue;
    if (memory[i] == 0) continue;
    memory[j++] = memory[i];
    memory[i] = 0;
  }
}
int alloc(int x) {
  int count = 0;
  int i;
  for (i = 0; i < m && count < x; i++) {
    if (memory[i] == 0)
      count++;
    else
      count = 0;
  }
  if (count < x) return -1;
  n++;
  for (int j = 0; j < x; j++) memory[i - j - 1] = n;
  return n;
}
bool erase(int x) {
  if (x <= 0) return false;
  for (int i = 0; i < m; i++)
    if (memory[i] == x) {
      while (i < m && memory[i] == x) memory[i++] = 0;
      return true;
    }
  return false;
}
int main() {
  int t, x;
  string s;
  cin >> t >> m;
  while (t--) {
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      x = alloc(x);
      if (x == -1)
        cout << "NULL" << endl;
      else
        cout << x << endl;
    } else if (s == "erase") {
      cin >> x;
      if (!erase(x)) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else
      defrag();
  }
}
