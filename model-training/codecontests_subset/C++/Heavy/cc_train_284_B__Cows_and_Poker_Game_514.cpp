#include <bits/stdc++.h>
using namespace std;
string str, str2;
long long n, m, t, k, j, p;
void printVec(string desc, vector<unsigned long long> vec) {
  cout << desc << ":" << endl;
  for (unsigned long long x = 0; x < vec.size(); x++) {
    cout << vec[x] << " ";
  }
  cout << endl;
}
int main() {
  cin.tie(NULL);
  cout.tie(NULL);
  ios_base::sync_with_stdio(false);
  cin >> n;
  cin >> str;
  int data[3];
  memset(data, 0, sizeof(data));
  for (int x = 0; x < n; x++) {
    if (str[x] == 'A') {
      data[0]++;
    } else if (str[x] == 'F') {
      data[1]++;
    } else {
      data[2]++;
    }
  }
  int total = 0;
  if (data[2] == 0) {
    total += data[0];
  }
  if (data[2] == 1) {
    total += 1;
  }
  cout << total << endl;
  return 0;
}
