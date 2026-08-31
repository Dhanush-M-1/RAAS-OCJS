#include <bits/stdc++.h>
using namespace std;
long long n, c;
pair<long long, long long> arr[100005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (long long i = (long long)(1); i <= (long long)(n); i++)
    cin >> arr[i].first >> arr[i].second;
  c = min((long long)2, n);
  for (long long i = (long long)(2); i <= (long long)(n - 1); i++) {
    if (arr[i].first - arr[i].second > arr[i - 1].first)
      c++;
    else if (arr[i].first + arr[i].second < arr[i + 1].first) {
      arr[i].first = arr[i].first + arr[i].second;
      c++;
    }
  }
  cout << c << endl;
  return 0;
}
