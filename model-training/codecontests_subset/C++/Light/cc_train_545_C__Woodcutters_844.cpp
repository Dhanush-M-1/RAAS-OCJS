#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n;
  cin >> n;
  vector<pair<long int, long int> > vec;
  for (long int i = 1; i <= n; i++) {
    long int a, b;
    cin >> a >> b;
    vec.push_back({a, b});
  }
  long int count = 1;
  long int limit = vec[0].first;
  for (long int i = 1; i <= n - 2; i++) {
    if (vec[i].first - vec[i].second > limit) {
      count++;
      limit = vec[i].first;
    } else if (vec[i].first + vec[i].second < vec[i + 1].first) {
      count++;
      limit = vec[i].first + vec[i].second;
    } else {
      limit = vec[i].first;
    }
  }
  if (n >= 2) count++;
  cout << count << endl;
}
