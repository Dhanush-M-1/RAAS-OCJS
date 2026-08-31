#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define REP(i,n) for(int i=0;i<n;i++)
#define PP(m) REP(i, m.size()) cout << m[i] << endl;

int main() {
  int N;

  while (cin >> N && N) {
    int c=0;
    vector<int> arr(N);
    REP(i, N) cin >> arr[i];
    REP(i, N-1) {
      REP(j, N-i-1) {
        if (arr[j] > arr[j+1] && arr[j] != arr[j+1]) {
          swap(arr[j], arr[j+1]);
          c++;
        }
      }
    }
    cout << c << endl;
  }
  return 0;
}