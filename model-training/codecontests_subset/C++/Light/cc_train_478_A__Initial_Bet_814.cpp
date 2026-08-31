#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  int x;
  long long int sum = 0;
  for (int i = 0; i < 5; i++) {
    cin >> x;
    sum += x;
  }
  if (sum == 0) {
    cout << -1 << endl;
  } else if (sum % 5 == 0) {
    cout << sum / 5 << endl;
  } else {
    cout << -1 << endl;
  }
}
