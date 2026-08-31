#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
template <class T>
typename T::value_type arr_sum(const T& v, int n) {
  typename T::value_type sum = 0;
  for (int i = (0); i < (n); ++i) sum += v[i];
  return sum;
}
struct Sync_stdio {
  Sync_stdio() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
  }
} _sync_stdio;
vector<vector<long long>> ans1(1000);
vector<vector<long long>> ans2(500000);
void split(int t) {
  const int C = 100;
  if (t < C) {
    ans2[t] = ans1[t];
    return;
  }
  for (int i = (0); i < (5); ++i) {
    if (ans1[C * i + t % C].size() == 0) {
      continue;
    }
    int t2 = (t - (C * i + t % C)) / C;
    if (t2 < 0 || ans2[t2].size() == 0) {
      continue;
    }
    ans2[t] = ans2[t2];
    for (int j = (0); j < (6); ++j) {
      ans2[t][j] *= C;
      ans2[t][j] += ans1[C * i + t % C][j];
    }
    return;
  }
}
vector<long long> dfs(long long t) {
  const int C = 100000;
  if (t < C) {
    return ans2[t];
  }
  for (int i = (0); i < (5); ++i) {
    if (ans2[C * i + t % C].size() == 0) {
      continue;
    }
    long long t2 = (t - (C * i + t % C)) / C;
    if (t2 < 0) {
      continue;
    }
    vector<long long> ans = dfs(t2);
    if (ans.size() == 0) {
      continue;
    }
    for (int j = (0); j < (6); ++j) {
      ans[j] *= C;
      ans[j] += ans2[C * i + t % C][j];
    }
    return ans;
  }
  return {};
}
int main() {
  for (int i = (0); i < (531441); ++i) {
    int t = i;
    int sum = 0;
    vector<long long> x(6);
    for (int j = (0); j < (6); ++j) {
      for (int k = (0); k < (2); ++k) {
        x[j] *= 10;
        x[j] += t % 3 == 0 ? 0 : (t % 3 == 1 ? 4 : 7);
        t /= 3;
      }
      sum += x[j];
    }
    if (ans1[sum].size() == 0) {
      ans1[sum] = x;
    }
  }
  for (int i = (0); i < (500000); ++i) {
    split(i);
  }
  int n;
  cin >> n;
  for (int i = (0); i < (n); ++i) {
    long long x;
    cin >> x;
    vector<long long> ans = dfs(x);
    if (ans.size() == 0) {
      cout << -1 << "\n";
    } else {
      for (auto j : ans) {
        cout << j << " ";
      }
      cout << "\n";
    }
  }
}
