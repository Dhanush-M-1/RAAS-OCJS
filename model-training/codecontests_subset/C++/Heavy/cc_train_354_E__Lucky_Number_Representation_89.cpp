#include <bits/stdc++.h>
using namespace std;
int four[128], seven[128];
int memoi[160000];
int memoj[160000];
int memok[160000];
int memol[160000];
vector<int> f(long long n) {
  if (n < 40000) {
    vector<int> v = {memol[n], memok[n], memoj[n], memoi[n]};
    return v;
  }
  int num = 0;
  vector<int> w;
  if (n % 10 == 0) num = 30;
  if (n % 10 == 1) num = 21;
  if (n % 10 == 2) num = 42;
  if (n % 10 == 3) num = 33;
  if (n % 10 == 4) num = 24;
  if (n % 10 == 5) num = 35;
  if (n % 10 == 6) num = 36;
  if (n % 10 == 7) num = 27;
  if (n % 10 == 8) num = 28;
  if (n % 10 == 9) num = 39;
  w = f((n - num) / 10);
  w.push_back(num);
  return w;
}
long long int res[8];
int main(void) {
  for (int i = (0); i < (int)(128); ++i) four[i] = seven[i] = -1;
  for (int i = (0); i < (int)(16000); ++i)
    memoi[i] = memoj[i] = memok[i] = memol[i] = -1;
  for (int i = (0); i < (int)(7); ++i)
    for (int j = (0); j < (int)(7 - i); ++j) {
      int num = 4 * i + 7 * j;
      four[num] = i;
      seven[num] = j;
    }
  for (int i = (0); i < (int)(50); ++i)
    for (int j = (0); j < (int)(50); ++j)
      for (int k = (0); k < (int)(50); ++k)
        for (int l = (0); l < (int)(50); ++l) {
          if (four[i] == -1) continue;
          if (four[j] == -1) continue;
          if (four[k] == -1) continue;
          if (four[l] == -1) continue;
          int num = i + j * 10 + k * 100 + l * 1000;
          memoi[num] = i;
          memoj[num] = j;
          memok[num] = k;
          memol[num] = l;
        }
  int q;
  cin >> q;
  for (int i = (0); i < (int)(q); ++i) {
    long long n;
    cin >> n;
    vector<int> v = f(n);
    memset(res, 0, sizeof(res));
    bool flag = true;
    for (int i = (0); i < (int)(v.size()); ++i) {
      if (v[i] == -1) flag = false;
      if (!flag) break;
      int fo = four[v[i]];
      int se = seven[v[i]];
      for (int j = (0); j < (int)(6); ++j) res[j] *= 10;
      for (int j = (0); j < (int)(fo); ++j) res[j] += 4;
      for (int j = (0); j < (int)(se); ++j) res[5 - j] += 7;
    }
    if (flag) {
      for (int i = (0); i < (int)(6); ++i) {
        if (i > 0) cout << " ";
        cout << res[i];
      }
      cout << endl;
    } else
      cout << -1 << endl;
  }
  return 0;
}
