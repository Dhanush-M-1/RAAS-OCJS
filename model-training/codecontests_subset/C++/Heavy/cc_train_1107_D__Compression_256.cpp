#include <bits/stdc++.h>
using namespace std;
int in() {
  int x;
  scanf("%d", &x);
  return x;
}
long long lin() {
  long long x;
  scanf("%lld", &x);
  return x;
}
void makegraph(int x, vector<vector<int> > &v) {
  for (long long i = 0; i < x - 1; i++) {
    int a = in(), b = in();
    v[a].push_back(b);
    v[b].push_back(a);
  }
}
template <typename A, size_t NNN, typename T>
void Fill(A (&array)[NNN], const T &val) {
  fill((T *)array, (T *)(array + NNN), val);
}
long long MOD = 1e9 + 7;
long long n, m, k;
long long a[255050];
long long sum[255050];
bool mat[6000][6000];
bool check(int x) {
  bool flag = true;
  for (long long i = 0; i < n / x; i++) {
    for (long long j = 0; j < n / x; j++) {
      bool checker = mat[i * x][j * x];
      for (long long ii = 0; ii < x; ii++) {
        for (long long jj = 0; jj < x; jj++) {
          if (checker != mat[ii + i * x][jj + j * x]) {
            flag = false;
            break;
          }
        }
        if (!flag) break;
      }
      if (!flag) break;
    }
    if (!flag) break;
  }
  return flag;
}
int main() {
  n = in();
  for (long long i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (long long j = 0; j < n / 4; j++) {
      int p = (s[j] - '0');
      if (p > 16) p -= 7;
      for (long long k = 0; k < 4; k++) {
        mat[i][j * 4 + 3 - k] = p % 2;
        p /= 2;
      }
    }
  }
  vector<pair<int, int> > factor;
  int nn = n;
  for (int i = 2; i * i <= nn; i++) {
    if (nn % i == 0) {
      int res = 0;
      while (nn % i == 0) {
        nn /= i;
        res++;
      }
      factor.push_back({i, res});
    }
  }
  if (nn > 1) factor.push_back({nn, 1});
  int ans = 1;
  for (long long i = 0; i < factor.size(); i++) {
    int res = 1;
    int preans = 1;
    for (long long j = 1; j <= factor[i].second; ++j) {
      res *= factor[i].first;
      if (check(res)) {
        preans = res;
      } else
        break;
    }
    ans *= preans;
  }
  cout << ans;
  return 0;
}
