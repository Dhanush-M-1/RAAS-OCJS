#include <iostream>

using namespace std;

int main(void) {
  int n;
  int count; //昇降の回数をカウント
  string f;
  for(;;) {
    cin >> n;
    int array[n];
    if(n == 0) break;
    for(int i=0;i<n;i++) {
      cin >> f;
      if(f == "lu") array[i] = 1;
      else if(f == "ru") array[i] = -1;
      else if (f == "ld") array[i] = 2;
      else if (f == "rd") array[i] = -2;
    }
    for(int i=0;i<n-1;i++) {
      if((array[i] + array[i+1]) == 0) count++;
    }
    cout << count << endl;
    count = 0;
  }
}

