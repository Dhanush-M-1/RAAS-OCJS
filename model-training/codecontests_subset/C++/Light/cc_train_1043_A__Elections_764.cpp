#include <bits/stdc++.h>
using namespace std;
int mcd(int, int);
int maxi(int, int, int);
int bus(int, int, int, vector<int>, int &, int &);
bool app(vector<int> &, int);
int main() {
  int n, num, suma = 0;
  vector<int> vec;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> num;
    vec.push_back(num);
    suma += num;
  }
  suma *= 2;
  sort(vec.begin(), vec.end());
  int k = suma / n;
  k++;
  if (k < vec[n - 1]) {
    cout << vec[n - 1];
  } else {
    cout << k;
  }
}
