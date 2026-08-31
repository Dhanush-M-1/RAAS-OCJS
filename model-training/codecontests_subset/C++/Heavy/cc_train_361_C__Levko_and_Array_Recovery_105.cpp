#include <bits/stdc++.h>
using namespace std;
class tu {
 public:
  tu(int a, int b, int c, int d) {
    t = a;
    i = b;
    j = c;
    v = d;
  }
  int t;
  int i, j;
  long long v;
};
long long ans[5009], ans2[5009];
vector<tu> ve;
int main() {
  int n1, n2;
  int a[4];
  cin >> n1 >> n2;
  for (int i = 0; i < n2; i++) {
    for (int i = 0; i < 4; i++) {
      cin >> a[i];
    }
    a[1]--;
    a[2]--;
    ve.push_back(tu(a[0], a[1], a[2], a[3]));
  }
  for (int i = 0; i < n1; i++) {
    ans[i] = (long long)1e18;
  }
  for (int i = n2 - 1; i >= 0; i--) {
    if (ve[i].t == 1) {
      for (int j = ve[i].i; j <= ve[i].j; j++) {
        ans[j] = ans[j] - ve[i].v;
      }
    } else {
      for (int j = ve[i].i; j <= ve[i].j; j++) {
        ans[j] = min(ans[j], ve[i].v);
      }
    }
  }
  for (int i = 0; i < n1; i++) ans2[i] = ans[i] = min(ans[i], (long long)1e9);
  for (int i = 0; i < n2; i++) {
    if (ve[i].t == 1) {
      for (int j = ve[i].i; j <= ve[i].j; j++) {
        ans[j] = ans[j] + ve[i].v;
      }
    } else {
      long long maxi = -(long long)1e18;
      for (int j = ve[i].i; j <= ve[i].j; j++) {
        maxi = max(ans[j], maxi);
      }
      if (maxi != ve[i].v) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 0; i < n1; i++) {
    cout << ans2[i] << (i == n1 - 1 ? '\n' : ' ');
  }
  return 0;
}
