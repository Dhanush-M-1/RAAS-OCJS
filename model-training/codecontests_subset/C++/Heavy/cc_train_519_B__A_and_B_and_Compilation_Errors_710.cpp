#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i;
  long long int data;
  cin >> n;
  long long int* all_errors;
  long long int* first_comp;
  long long int* second_comp;
  all_errors = new long long int[n];
  first_comp = new long long int[n - 1];
  second_comp = new long long int[n - 2];
  for (i = 0; i < n; i++) cin >> all_errors[i];
  for (i = 0; i < n - 1; i++) cin >> first_comp[i];
  for (i = 0; i < n - 2; i++) cin >> second_comp[i];
  sort(all_errors, all_errors + n);
  sort(first_comp, first_comp + (n - 1));
  sort(second_comp, second_comp + (n - 2));
  bool flag1 = false;
  bool flag2 = false;
  for (i = 0; i < n; i++) {
    if (all_errors[i] != first_comp[i]) {
      flag1 = true;
      cout << all_errors[i] << endl;
      break;
    }
  }
  if (!flag1) {
    cout << all_errors[n - 1] << endl;
  }
  for (i = 0; i < n - 1; i++) {
    if (second_comp[i] != first_comp[i]) {
      flag2 = true;
      cout << first_comp[i] << endl;
      break;
    }
  }
  if (!flag2) cout << second_comp[n - 2] << endl;
  return 0;
}
