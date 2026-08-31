#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
read:
  while (t--) {
    int a, b;
    cin >> a >> b;
    long long int ar[a];
    long long int arr[b];
    for (int i = 0; i < a; i++) {
      cin >> ar[i];
    }
    for (int i = 0; i < b; i++) {
      cin >> arr[i];
    }
    sort(ar, ar + a);
    for (int i = 0; i < b; i++) {
      bool ans = binary_search(ar, ar + a, arr[i]);
      if (ans == 1) {
        cout << "YES" << endl << 1 << " " << arr[i] << endl;
        goto read;
      }
    }
    cout << "NO" << endl;
  }
  return 0;
}
