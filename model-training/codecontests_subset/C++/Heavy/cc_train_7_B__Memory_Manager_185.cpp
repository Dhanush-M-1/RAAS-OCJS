#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:64000000")
using namespace std;
void __never(int a) { printf("\nOPS %d", a); }
int n, t;
int mem[200];
int cc = 0;
void init() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}
bool can(int pos, int co) {
  if (pos + co - 1 > n) return false;
  for (int(i) = (pos); (i) <= (pos + co - 1); ++(i))
    if (mem[i] > 0) return false;
  return true;
}
string _Alloc(int a) {
  for (int(i) = (1); (i) <= (n); ++(i))
    if (can(i, a)) {
      cc++;
      for (int(j) = (i); (j) <= (i + a - 1); ++(j)) mem[j] = cc;
      stringstream ss;
      ss << cc;
      return ss.str();
    }
  return "NULL";
}
bool _Erase(int a) {
  if (a < 1 || a > cc) return false;
  bool was = false;
  for (int(i) = (1); (i) <= (n); ++(i))
    if (mem[i] == a) {
      was = true;
      mem[i] = 0;
    }
  return was;
}
void _Defrag() {
  int cur = 0;
  for (int(i) = (1); (i) <= (n); ++(i))
    if (mem[i] == 0) {
      cur++;
    } else {
      mem[i - cur] = mem[i];
      if (cur > 0) mem[i] = 0;
    }
}
void sol() {
  string s;
  int arg = 0;
  for (int(T) = (1); (T) <= (t); ++(T)) {
    cin >> s;
    if (s[0] == 'a') {
      cin >> arg;
      cout << _Alloc(arg) << endl;
    } else if (s[0] == 'e') {
      cin >> arg;
      if (!_Erase(arg)) printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else if (s[0] == 'd') {
      _Defrag();
    } else {
      if (!(false)) {
        __never(81);
        cout.flush();
        cerr.flush();
        abort();
      }
    };
  }
}
int main() {
  scanf("%d %d", &t, &n);
  sol();
  return 0;
}
