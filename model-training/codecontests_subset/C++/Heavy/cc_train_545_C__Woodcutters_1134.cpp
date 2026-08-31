#include <bits/stdc++.h>
using namespace std;
pair<int, int> arr[100009];
int main() {
  int a, san = 0, last = 0;
  cin >> a;
  for (int i = 0; i < a; i++) cin >> arr[i].first >> arr[i].second;
  for (int i = 0; i < a; i++) {
    if (i == 0 or i == a - 1) {
      if (i == 0)
        last = arr[i].first, san++;
      else if (i == a - 1 and arr[i].first > last)
        san++;
    } else {
      if (arr[i].first - arr[i].second > last and
          arr[i - 1].first < arr[i].first - arr[i].second) {
        san++;
        last = arr[i].first;
      } else if (arr[i].first + arr[i].second < arr[i + 1].first and
                 arr[i].first > last) {
        san++;
        last = arr[i].first + arr[i].second;
      }
    }
  }
  cout << san << endl;
  return 0;
}
