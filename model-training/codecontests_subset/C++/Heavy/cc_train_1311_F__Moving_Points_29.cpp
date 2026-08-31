#include <bits/stdc++.h>
using namespace std;
vector<long> inverse(vector<long>& perm) {
  long n = perm.size();
  vector<long> ret(n);
  for (long i = 0; i < n; ++i) {
    ret[perm[i]] = i;
  }
  return ret;
}
vector<long> assignPermutation(const vector<long>& uniqs) {
  long n = uniqs.size();
  vector<pair<long, long>> withIndices(n);
  for (long i = 0; i < n; ++i) {
    withIndices[i] = {uniqs[i], i};
  }
  sort(withIndices.begin(), withIndices.end());
  vector<long> temp(n);
  for (long i = 0; i < n; ++i) {
    temp[i] = withIndices[i].second;
  }
  return inverse(temp);
}
int main() {
  long n;
  cin >> n;
  cin.ignore();
  vector<long> x(n);
  vector<long> v(n);
  vector<pair<long, long>> data(n);
  for (long i = 0; i < n; ++i) {
    cin >> x[i];
  }
  cin.ignore();
  for (long i = 0; i < n; ++i) {
    cin >> v[i];
    data[i] = {v[i], x[i]};
  }
  cin.ignore();
  sort(data.begin(), data.end());
  vector<long> xtemp(n);
  for (long i = 0; i < n; ++i) xtemp[i] = data[i].second;
  auto xranks = assignPermutation(xtemp);
  sort(x.begin(), x.end());
  long long totsum = 0;
  for (long i = 0; i < n; ++i) {
    totsum += (long long)(i)*x[i];
    totsum -= (long long)(n - 1 - i) * x[i];
  }
  for (long i = 0; i < n; ++i) {
    long netleftjumps = i - xranks[i];
    totsum += (long long)(netleftjumps)*xtemp[i];
  }
  cout << totsum << endl;
}
