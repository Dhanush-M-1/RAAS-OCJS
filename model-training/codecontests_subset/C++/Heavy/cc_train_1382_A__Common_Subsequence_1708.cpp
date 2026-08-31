#include <bits/stdc++.h>
using namespace std;
using namespace std;
int main() {
  int cases;
  cin >> cases;
  while (cases--) {
    int n, m;
    cin >> n >> m;
    int one[n], two[m];
    for (int i = 0; i < n; i++) {
      cin >> one[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> two[i];
    }
    int arr1[1000], arr2[1000];
    for (int i = 0; i < 1000; i++) {
      arr1[i] = 0;
      arr2[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      arr1[one[i] - 1]++;
    }
    for (int i = 0; i < m; i++) {
      arr2[two[i] - 1]++;
    }
    int temp = 0;
    for (int i = 0; i < 1000; i++) {
      if (arr1[i] != 0 && arr2[i] != 0) {
        temp = i + 1;
        break;
      }
    }
    if (temp) {
      cout << "YES" << endl;
      cout << "1"
           << " " << temp << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
