#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> vec(n);
  for (int i = 0; i < n; ++i) cin >> vec[i];
  int sum = accumulate(vec.begin(), vec.end(), 0);
  if ((sum / 100) % 2 != 0) {
    cout << "NO\n";
    return 0;
  }
  sum /= 2;
  int num_one = count(vec.begin(), vec.end(), 100);
  int num_two = count(vec.begin(), vec.end(), 200);
  int curr = 0;
  while (curr <= sum && num_two > 0) {
    curr += 200;
    num_two--;
  }
  if (curr == sum) {
    cout << "YES\n";
    return 0;
  }
  if (curr > sum) curr -= 200;
  while (curr != sum && num_one > 0) {
    curr += 100;
    num_one--;
  }
  if (curr == sum)
    cout << "YES\n";
  else
    cout << "NO\n";
}
