#include<iostream>
using namespace std;
const int INF = 2000000;

int main() {
  int n;
  while (cin >> n and n != 0) {
    int* arr = new int[n];

    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }

    int val = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < i; j++)
        if (arr[j] > arr[i]) val++;

    cout << val << endl;
  }
}