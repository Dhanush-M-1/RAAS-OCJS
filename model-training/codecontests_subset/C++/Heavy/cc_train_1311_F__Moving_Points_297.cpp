#include <bits/stdc++.h>
using namespace std;
int MOD = 1000000000 + 7;
long long int inverse(long long int i) {
  if (i == 1) return 1;
  return (MOD - ((MOD / i) * inverse(MOD % i)) % MOD + MOD) % MOD;
}
long long int calc(vector<pair<long long int, long long int>>& v1, int st,
                   int fn) {
  if (fn - st + 1 <= 1) return 0;
  vector<pair<int, int>> temp(fn - st + 1);
  int mid = (st + fn) / 2;
  long long int r1 = calc(v1, st, mid);
  r1 = r1 + calc(v1, mid + 1, fn);
  long long int sum3 = 0;
  for (int i = mid + 1; i <= fn; ++i) sum3 += v1[i].first;
  int j = mid + 1;
  for (int i = st; i <= mid; ++i) {
    while (j <= fn && v1[j].second < v1[i].second) {
      sum3 -= v1[j].first;
      j++;
    }
    r1 = r1 + (sum3 - (fn - j + 1) * v1[i].first);
  }
  int st1 = st, st2 = mid + 1;
  int count1 = 0;
  while (st1 <= mid && st2 <= fn) {
    if (v1[st1].second <= v1[st2].second) {
      temp[count1].first = v1[st1].first;
      temp[count1].second = v1[st1].second;
      count1++;
      st1++;
    } else {
      temp[count1].first = v1[st2].first;
      temp[count1].second = v1[st2].second;
      count1++;
      st2++;
    }
  }
  for (int i = st1; i <= mid; ++i) {
    temp[count1].first = v1[i].first;
    temp[count1].second = v1[i].second;
    count1++;
  }
  for (int i = st2; i <= fn; ++i) {
    temp[count1].first = v1[i].first;
    temp[count1].second = v1[i].second;
    count1++;
  }
  for (int i = st; i <= fn; ++i) {
    v1[i].first = temp[i - st].first;
    v1[i].second = temp[i - st].second;
  }
  return r1;
}
int main() {
  int n;
  cin >> n;
  vector<pair<long long int, long long int>> v1, v2;
  vector<long long int> temp1, temp2;
  long long int x[n], v[n];
  for (int i = 0; i < n; ++i) scanf("%lld", x + i);
  for (int i = 0; i < n; ++i) scanf("%lld", v + i);
  for (int i = 0; i < n; ++i) {
    if (v[i] >= 0) {
      v1.push_back({x[i], v[i]});
      temp1.push_back(x[i]);
    } else {
      v2.push_back({x[i], v[i]});
      temp2.push_back(x[i]);
    }
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  long long int y = 0;
  int n1 = v1.size();
  int n2 = v2.size();
  y = y + calc(v1, 0, n1 - 1);
  y = y + calc(v2, 0, n2 - 1);
  sort(temp1.begin(), temp1.end());
  sort(temp2.begin(), temp2.end());
  int n3 = temp2.size();
  long long int sum4 = 0;
  int st1 = 0;
  for (int i = 0; i < temp1.size(); ++i) {
    while (st1 < n3 && temp2[st1] < temp1[i]) {
      sum4 += temp2[st1];
      st1++;
    }
    y = y + st1 * temp1[i] - sum4;
  }
  printf("%lld\n", y);
}
