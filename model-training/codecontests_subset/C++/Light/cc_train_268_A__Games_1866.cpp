#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, arr[60], arr_2[60], count = 0;
  cin >> x;
  x *= 2;
  for (int i = 0; i < x; i++) cin >> arr[i];
  for (int i = 0; i < x; i += 2) {
    for (int j = 1; j < x; j += 2) {
      if (arr[i] == arr[j]) count++;
    }
  }
  cout << count << endl;
  return 0;
}
