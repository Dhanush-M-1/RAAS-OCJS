#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n;
  cin >> n;
  int x;
  int first_error = 0;
  int second_error = 0;
  int first_sum = 0;
  int second_sum = 0;
  int third_sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    first_sum += x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    second_sum += x;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    third_sum += x;
  }
  first_error = first_sum - second_sum;
  second_error = second_sum - third_sum;
  cout << first_error << endl;
  cout << second_error << endl;
  return 0;
}
