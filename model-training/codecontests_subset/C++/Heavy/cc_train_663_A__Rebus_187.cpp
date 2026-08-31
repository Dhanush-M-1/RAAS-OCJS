#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  getline(cin, str);
  int arr[200], counter = 1, n, sum = 1;
  arr[0] = 1;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '+') {
      arr[counter] = 1;
      counter++;
      sum++;
    } else if (str[i] == '-') {
      arr[counter] = -1;
      counter++;
      sum--;
    } else if (str[i] == '=') {
      istringstream s(str.substr(i + 1, str.length() - (i + 1)));
      s >> n;
    }
  }
  for (int i = 0; i < counter; i++) {
    if (sum < n) {
      while (arr[i] > 0 && arr[i] < n && sum < n) {
        sum++;
        arr[i]++;
      }
      if (arr[i] < -1) {
        while (arr[i] < -1 && sum < n) {
          sum++;
          arr[i]++;
        }
      }
    } else if (sum > n) {
      while (arr[i] < 0 && abs(arr[i]) < n && sum > n) {
        sum--;
        arr[i]--;
      }
      if (arr[i] > 1) {
        while (arr[i] > 1 && sum > n) {
          sum--;
          arr[i]--;
        }
      }
    } else if (sum == n)
      break;
  }
  if (sum != n) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  cout << arr[0];
  for (int i = 1; i < counter; i++) {
    if (arr[i] > 0)
      cout << " + ";
    else if (arr[i] < 0)
      cout << " - ";
    cout << abs(arr[i]);
  }
  cout << " = " << n;
}
