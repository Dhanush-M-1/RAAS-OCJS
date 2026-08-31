#include <bits/stdc++.h>
using namespace std;
const double pi = 3.14159265358979323846264338327950288419716939937511;
const double eps = 1e-9;
char ch_ch_ch[1 << 20];
inline string gs() {
  scanf("%s", ch_ch_ch);
  return string(ch_ch_ch);
}
inline string gl() {
  gets(ch_ch_ch);
  return string(ch_ch_ch);
}
inline int gi() {
  int x;
  scanf("%d", &x);
  return x;
}
const int inf = 1000000000;
int n, m;
vector<int> tp;
vector<int> l;
vector<int> r;
vector<int> val;
vector<int> a;
vector<int> was;
vector<int> res;
void solution() {
  n = gi();
  m = gi();
  for (int i = 0; i < (m); ++i) {
    tp.push_back(gi());
    l.push_back(gi() - 1);
    r.push_back(gi() - 1);
    val.push_back(gi());
  }
  a.resize(n, 0);
  was.resize(n, 0);
  for (int i = m - 1; i >= 0; --i) {
    if (tp[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) a[j] -= val[i];
    } else {
      for (int j = l[i]; j <= r[i]; ++j)
        if (!was[j]) {
          a[j] = val[i];
          was[j] = 1;
        } else {
          if (a[j] > val[i]) a[j] = val[i];
        }
    }
  }
  res = a;
  for (int i = 0; i < (n); ++i)
    if (a[i] < -inf) {
      cout << "NO\n" << endl;
    }
  for (int i = 0; i < (n); ++i)
    if (a[i] > inf) a[i] = inf;
  for (int i = 0; i < (m); ++i) {
    if (tp[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) a[j] += val[i];
    } else {
      bool cnt = 0;
      for (int j = l[i]; j <= r[i]; ++j)
        if (a[j] > val[i]) {
          cout << "NO\n";
          return;
        } else if (a[j] == val[i])
          cnt++;
      if (cnt == 0) {
        cout << "NO\n";
        return;
      }
    }
  }
  cout << "YES\n";
  for (int i = 0; i < (n); ++i) printf("%d%c", res[i], i + 1 == n ? '\n' : ' ');
}
int main(int argc, char** argv) {
  solution();
  return 0;
}
