#include <bits/stdc++.h>
using namespace std;
const double EPS = 0.0000001;
const double PI = acos(-1);
const long long INFLL = 0x7FFFFFFFFFFFFFFF;
const int INF = 0x7FFFFFFF;
template <typename T>
inline void next(T &num) {
  char c;
  num = 0;
  do {
    c = getchar_unlocked();
  } while (c != EOF && c == ' ' && c == '\n' && c == '\t');
  int sign = (c == '-' ? -1 : 1);
  if (c != '-') num += (c - '0');
  while ((c = getchar_unlocked()) != EOF && c != '\n' && c != '\t' &&
         c != ' ') {
    num *= 10;
    num += (c - '0');
  }
  num *= sign;
}
int nx[1005], n, x;
bitset<1005> sabi;
vector<int> pin;
pair<int, int> cari(int init, int num) {
  int pos = 0, pjg = 0;
  for (; init; init = nx[init], ++pjg)
    if (init == num) pos = pjg + 1;
  return make_pair(pos, pjg);
}
int main() {
  scanf("%d%d", &n, &x);
  for (int i = int(1), _b = int(n); i <= _b; ++i) {
    int t;
    scanf("%d", &t);
    if (t)
      nx[t] = i;
    else
      pin.push_back(i);
  }
  sabi[0] = 1;
  int pos;
  for (__typeof(pin.begin()) i = pin.begin(); i != pin.end(); i++) {
    int cur = *i;
    pair<int, int> tmp = cari(cur, x);
    if (tmp.first) {
      pos = tmp.first;
      continue;
    }
    for (int i = int(1000 - tmp.second), _b = int(0); i >= _b; --i)
      if (sabi[i]) sabi[i + tmp.second] = 1;
  }
  for (int i = int(0), _b = int(n - pos); i <= _b; ++i)
    if (sabi[i]) printf("%d\n", pos + i);
  return 0;
}
