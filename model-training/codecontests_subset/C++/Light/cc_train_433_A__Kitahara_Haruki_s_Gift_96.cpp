#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long int n, count_200 = 0, count_100 = 0;
  cin >> n;
  vector<long int> v;
  for (long int i = 0; i < n; i++) {
    long int temp;
    cin >> temp;
    v.push_back(temp);
    if (temp == 200) count_200++;
    if (temp == 100) count_100++;
  }
  if (count_200 == 0) {
    if (count_100 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  } else if (count_100 == 0) {
    if (count_200 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  } else if (count_200 % 2 == 0) {
    if (count_100 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  } else {
    if (count_100 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  }
  return 0;
}
