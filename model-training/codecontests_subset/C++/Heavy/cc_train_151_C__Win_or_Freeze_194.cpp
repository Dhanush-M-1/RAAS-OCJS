#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long> > do_it(long long n) {
  vector<pair<long long, long long> > res;
  if (n % 2 == 0) {
    long long cnt = 0;
    while (n % 2 == 0) n /= 2, cnt++;
    res.push_back(make_pair(2, cnt));
  }
  for (long long i = 3; i * i <= n; i += 2) {
    if (n % i == 0) {
      long long cnt = 0;
      while (n % i == 0) {
        n /= i, cnt++;
      }
      res.push_back(make_pair(i, cnt));
    }
  }
  if (n != 1) {
    res.push_back(make_pair(n, 1));
  }
  return res;
}
int main(void) {
  long long q;
  cin >> q;
  vector<pair<long long, long long> > res = do_it(q);
  long long sum = 0;
  if (q == 1) {
    cout << 1 << endl;
    cout << 0 << endl;
    return 0;
  }
  for (long long i = 0; i < res.size(); i++) sum += res[i].second;
  if (sum == 1) {
    cout << 1 << endl;
    cout << 0 << endl;
  } else if (sum == 2) {
    cout << 2 << endl;
  } else {
    cout << 1 << endl;
    long long tot = 1, cnt = 0;
    long long k = 0;
    while (k < res.size() && cnt <= sum - 2) {
      if (cnt + res[k].second < sum - 2) {
        for (long long z = 0; z < res[k].second; z++) tot *= res[k].first;
        cnt += res[k].second;
        k++;
      } else if (cnt + res[k].second == sum - 2) {
        for (long long z = 0; z < res[k].second; z++) tot *= res[k].first;
        cnt += res[k].second;
        k++;
        break;
      } else if (cnt + res[k].second > sum - 2) {
        for (long long z = 0; z < sum - 2 - cnt; z++) tot *= res[k].first;
        break;
      }
    }
    cout << q / tot << endl;
  }
  return 0;
}
