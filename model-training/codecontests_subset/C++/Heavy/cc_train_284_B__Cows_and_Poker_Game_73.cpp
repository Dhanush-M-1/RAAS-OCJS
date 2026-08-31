#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T MAX(T a, T b) {
  if (a > b) return a;
  return b;
}
template <class T>
inline T MIN(T a, T b) {
  if (a < b) return a;
  return b;
}
template <class T>
inline T ABS(T x) {
  if (x < 0) return -x;
  return x;
}
inline void OPEN(const string &s) {
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
}
const static int inf = 1000000000;
int n;
char input[200005];
bool ada = false;
int main() {
  scanf("%d", &n);
  scanf("%s", input);
  int a = 0, b = 0;
  for (int(i) = (0); (i) < (n); ++(i)) {
    if (input[i] == 'I') {
      a++;
      ada = true;
    } else if (input[i] == 'A') {
      b++;
    }
  }
  if (ada) {
    if (a == 1)
      printf("1\n");
    else
      printf("0\n");
  } else
    printf("%d\n", b);
}
