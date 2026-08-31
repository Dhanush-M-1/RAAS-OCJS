#include <bits/stdc++.h>
using namespace std;
string arr[5205];
string st[5205];
vector<int> result;
void hexToBinary(string str, int i) {
  for (int j = 0; j < str.length(); j++) {
    switch (str[j]) {
      case '0':
        arr[i].insert(arr[i].length(), "0000");
        break;
      case '1':
        arr[i].insert(arr[i].length(), "0001");
        break;
      case '2':
        arr[i].insert(arr[i].length(), "0010");
        break;
      case '3':
        arr[i].insert(arr[i].length(), "0011");
        break;
      case '4':
        arr[i].insert(arr[i].length(), "0100");
        break;
      case '5':
        arr[i].insert(arr[i].length(), "0101");
        break;
      case '6':
        arr[i].insert(arr[i].length(), "0110");
        break;
      case '7':
        arr[i].insert(arr[i].length(), "0111");
        break;
      case '8':
        arr[i].insert(arr[i].length(), "1000");
        break;
      case '9':
        arr[i].insert(arr[i].length(), "1001");
        break;
      case 'A':
        arr[i].insert(arr[i].length(), "1010");
        break;
      case 'B':
        arr[i].insert(arr[i].length(), "1011");
        break;
      case 'C':
        arr[i].insert(arr[i].length(), "1100");
        break;
      case 'D':
        arr[i].insert(arr[i].length(), "1101");
        break;
      case 'E':
        arr[i].insert(arr[i].length(), "1110");
        break;
      case 'F':
        arr[i].insert(arr[i].length(), "1111");
        break;
    }
  }
}
void solve() {
  long long n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    arr[i] = "";
  }
  for (int i = 0; i < n; i++) {
    cin >> st[i];
    hexToBinary(st[i], i);
  }
  int i = 1;
  while (i * i <= n) {
    if (n % i == 0) {
      result.push_back(i);
      if (n / i != i) result.push_back(n / i);
    }
    i++;
  }
  sort(result.begin(), result.end());
  int sz = result.size() - 1;
  int ans;
  for (int i = sz; i >= 0; i--) {
    int fact = result[i];
    int flag = 0;
    for (long long i = 0; i < n; i += fact) {
      for (long long j = i + 1; j < i + fact; j++) {
        if (st[j] != st[j - 1]) {
          flag = 1;
          break;
        }
      }
      if (flag == 1) break;
    }
    for (int i = 0; i < n; i += fact) {
      for (int j = 0; j < n; j += fact) {
        string one = arr[i].substr(j, fact);
        for (int k = 1; k < one.length(); k++) {
          if (one[k] != one[k - 1]) {
            flag = 1;
            break;
          }
        }
        if (flag == 1) break;
      }
      if (flag == 1) {
        break;
      }
    }
    if (flag == 0) {
      ans = fact;
      break;
    }
  }
  cout << ans << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
