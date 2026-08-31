#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  vector<pair<int, int>> a, b, c, z;
  a.reserve(n);
  b.reserve(n);
  c.reserve(n);
  z.reserve(n);
  for (int i = 0; i < n; ++i) {
    int t, xa, xb;
    scanf("%d%d%d", &t, &xa, &xb);
    if (xa == 1 && xb == 1) {
      z.push_back(make_pair(t, i + 1));
    } else if (xa == 1 && xb == 0) {
      a.push_back(make_pair(t, i + 1));
    } else if (xa == 0 && xb == 1) {
      b.push_back(make_pair(t, i + 1));
    } else if (xa == 0 && xb == 0) {
      c.push_back(make_pair(t, i + 1));
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  sort(z.begin(), z.end());
  if (min(a.size(), b.size()) + z.size() < k) {
    printf("-1\n");
    return 0;
  }
  int cz = min<int>(z.size(), k);
  int ca = k - cz;
  int cb = k - cz;
  int cc = 0;
  if (cz + ca + cb > m) {
    printf("-1\n");
    return 0;
  }
  while (ca < a.size() && cb < b.size() && cz > 0) {
    if (z[cz - 1].first > a[ca].first + b[cb].first) {
      if (cz + ca + cb + 1 > m) {
        break;
      }
      cz--;
      ca++;
      cb++;
    } else {
      break;
    }
  }
  while (ca + cb + cc + cz < m) {
    int tm = 1000000001;
    if (ca < a.size()) {
      tm = min<int>(tm, a[ca].first);
    }
    if (cb < b.size()) {
      tm = min<int>(tm, b[cb].first);
    }
    if (cc < c.size()) {
      tm = min<int>(tm, c[cc].first);
    }
    if (cz < z.size()) {
      tm = min<int>(tm, z[cz].first);
    }
    if (ca < a.size() && tm == a[ca].first) {
      ca++;
      if (cz > 0 && cb < b.size()) {
        if (z[cz - 1].first > b[cb].first) {
          cz--;
          cb++;
        }
      }
    } else if (cb < b.size() && tm == b[cb].first) {
      cb++;
      if (cz > 0 && ca < a.size()) {
        if (z[cz - 1].first > a[ca].first) {
          cz--;
          ca++;
        }
      }
    } else if (cc < c.size() && tm == c[cc].first) {
      cc++;
    } else if (cz < z.size() && tm == z[cz].first) {
      cz++;
    }
  }
  long long int answer = 0;
  vector<int> ans;
  ans.reserve(n);
  for (int i = 0; i < cz; ++i) {
    answer += z[i].first;
    ans.push_back(z[i].second);
  }
  for (int i = 0; i < ca; ++i) {
    answer += a[i].first;
    ans.push_back(a[i].second);
  }
  for (int i = 0; i < cb; ++i) {
    answer += b[i].first;
    ans.push_back(b[i].second);
  }
  for (int i = 0; i < cc; ++i) {
    answer += c[i].first;
    ans.push_back(c[i].second);
  }
  printf("%lld\n", answer);
  sort(ans.begin(), ans.end());
  for (int i = 0; i < ans.size(); ++i) {
    printf("%d", ans[i]);
    if (i < ans.size() - 1) {
      printf(" ");
    } else {
      printf("\n");
    }
  }
  return 0;
}
