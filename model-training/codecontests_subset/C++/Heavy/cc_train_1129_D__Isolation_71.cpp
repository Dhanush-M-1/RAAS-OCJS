#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2")
#pragma warning(disable : 4996)
using namespace std;
const long long int mod = 998244353;
long long int sum = 1;
void add(int* anums, long long int* aanss, int X, bool flag) {
  if (flag) {
    for (int x = 0; x < X; ++x) {
      anums[x]--;
      if (!anums[x]) sum += aanss[x];
    }
  } else {
    for (int x = 0; x < X; ++x) {
      if (!anums[x]) sum -= aanss[x];
      anums[x]++;
    }
  }
}
int nums[100010];
int pres[100010];
long long int anss[100010];
int main() {
  int N, M;
  cin >> N >> M;
  vector<int> v(N);
  for (int i = 0; i < N; ++i) {
    scanf("%d", &v[i]);
    v[i]--;
  }
  map<int, int> mp;
  for (int i = 0; i < N; ++i) {
    if (mp.find(v[i]) == mp.end()) {
      pres[i] = 0;
    } else {
      pres[i] = mp[v[i]];
    }
    mp[v[i]] = i + 1;
  }
  for (int i = 0; i <= N; ++i) nums[i] = -M;
  anss[0] = 1;
  for (int i = 0; i < N; ++i) {
    if (pres[i]) {
      add(nums + pres[pres[i] - 1], anss + pres[pres[i] - 1],
          pres[i] - pres[pres[i] - 1], true);
    }
    add(nums + pres[i], anss + pres[i], i - pres[i] + 1, false);
    anss[i + 1] = sum % mod;
    if (anss[i + 1] < 0) anss[i + 1] += mod;
    sum += anss[i + 1];
  }
  cout << anss[N] << endl;
  return 0;
}
