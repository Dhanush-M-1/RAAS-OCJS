#include<iostream>
#include<vector>
using namespace std;

int main() {
  int n;
  while (cin >> n && n) {
    vector<int> v;
    for (int i = 0; i < n; i++) {
      int a;
      cin >> a;
      v.push_back(a);
    }
    int count = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (v[i] > v[j]) {
          count++;
        }
      }
    }
    cout << count << endl;
  }
}