#include <bits/stdc++.h>
using namespace std;
vector<int> read_int_array(int n) {
  vector<int> arr;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    arr.push_back(temp);
  }
  return arr;
}
vector<long long int> read_llint_array(int n) {
  vector<long long int> arr;
  for (int i = 0; i < n; i++) {
    long long int temp;
    cin >> temp;
    arr.push_back(temp);
  }
  return arr;
}
int main() {
  string n1, n2;
  cin >> n1 >> n2;
  int n;
  cin >> n;
  cout << n1 << " " << n2 << endl;
  for (int i = 0; i < n; i++) {
    string killed, repl;
    cin >> killed >> repl;
    if (n1 == killed) {
      n1 = repl;
    } else {
      n2 = repl;
    }
    cout << n1 << " " << n2 << endl;
  }
  return 0;
}
