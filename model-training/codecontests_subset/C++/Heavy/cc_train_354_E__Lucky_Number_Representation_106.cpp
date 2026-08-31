#include <bits/stdc++.h>
using namespace std;
const int INF = (int)1e9;
const long long INF64 = (long long)1e18;
const long double eps = 1e-9;
const long double pi = 3.14159265358979323846;
int dp[20][50];
int frmP[20][50], frmQ[20][50], frmE[20][50];
long long ten[20];
char str[60];
vector<long long> arr;
pair<long long, long long> rev[60];
long long num[20];
void update(int p1, int q1, int p2, int q2, int val) {
  if (dp[p1][q1] == 0) {
    dp[p1][q1] = 1;
    frmP[p1][q1] = p2;
    frmQ[p1][q1] = q2;
    frmE[p1][q1] = val;
  }
}
void re(int p1, int q1, int dep) {
  if (p1) {
    re(frmP[p1][q1], frmQ[p1][q1], dep + 1);
    int xx, yy;
    int i;
    long long val;
    val = arr[frmE[p1][q1]];
    xx = rev[val].first;
    yy = rev[val].second;
    for (i = 0; i < xx; i++) num[i] += (4LL * ten[dep]);
    for (i = 0; i < yy; i++) num[i + xx] += (7LL * ten[dep]);
  }
}
int main() {
  long long i, j, k;
  for (i = 0; i <= 6; i++) {
    for (j = 0; j + i <= 6; j++) {
      arr.push_back(i * 4 + 7 * j);
      rev[i * 4 + 7 * j] = (make_pair(i, j));
    }
  }
  sort((arr).begin(), (arr).end());
  int tn;
  int len;
  long long t;
  t = 1;
  for (i = 0; i <= 18; i++) {
    ten[i] = t;
    t *= 10LL;
  }
  cin >> tn;
  while (tn--) {
    cin >> str;
    len = strlen(str);
    memset(dp, 0, sizeof(dp));
    dp[0][0] = 1;
    for (i = 1; i <= len; i++) {
      for (j = 0; j < 50; j++) {
        if (dp[i - 1][j]) {
          t = j * 10LL + (str[i - 1] - '0');
          for (k = 0; k < (int((arr).size())) && arr[k] <= t; k++) {
            if (t - arr[k] < 50LL) {
              update(i, t - arr[k], i - 1, j, k);
            }
          }
        }
      }
    }
    if (!dp[len][0])
      printf("-1\n");
    else {
      memset(num, 0, sizeof(num));
      re(len, 0, 0);
      for (i = 0; i < 6; i++) {
        if (i) printf(" ");
        cout << num[i];
      }
      puts("");
    }
  }
  return 0;
}
