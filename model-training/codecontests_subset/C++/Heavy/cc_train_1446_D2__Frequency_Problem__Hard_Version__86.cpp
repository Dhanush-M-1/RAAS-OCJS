#include <bits/stdc++.h>
const int M = 200001;
using namespace std;
int main() {
  long n;
  cin >> n;
  long a[n + 1], tp[n + 1], num;
  pair<long, long> cnt[M];
  memset(cnt, 0, sizeof cnt);
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    cnt[a[i]].first++;
    cnt[a[i]].second = a[i];
  }
  sort(cnt, cnt + M, greater<pair<long long, long long>>());
  long mx = cnt[0].second;
  if (cnt[0].first == cnt[1].first)
    cout << n;
  else {
    long rez = 0;
    for (int i = 1; cnt[i].first >= sqrt(n); i++) {
      if (i != mx) {
        long P[2 * n + 1], ts = n;
        memset(P, -1, sizeof(P));
        P[n] = 0;
        for (int j = 1; j <= n; j++) {
          ts += (a[j] == mx) - (a[j] == cnt[i].second);
          if (P[ts] != -1)
            rez = max(rez, j - P[ts]);
          else
            P[ts] = j;
        }
      }
    }
    for (int c = 1; c <= sqrt(n); c++) {
      memset(tp, 0, sizeof(tp));
      num = 0;
      for (int l = 1, r = 1; r <= n; r++) {
        num -= (tp[a[r]] == c);
        tp[a[r]]++;
        num += (tp[a[r]] == c);
        while (tp[a[r]] > c) {
          num -= (tp[a[l]] == c);
          tp[a[l]]--;
          num += (tp[a[l]] == c);
          l++;
        }
        if (num > 1) rez = max(rez, (long)(r - l + 1));
      }
    }
    cout << rez;
  }
  return 0;
}
