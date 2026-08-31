#include <iostream>
#include <vector>
using namespace std;

int main(void){
  while(true){
    int n;
    cin >> n;
    if(n == 0){ break; }

    string input;
    vector<int> w(n);
    for(int i = 0; i < n; i++){
      cin >> input;
      w[i] = input.length();
    }

    int tank[] = {5, 7, 5, 7, 7};
    for(int i = 0; i < n; i++){
      int phase = 0;
      int nowCount = 0;
      for(int j = i; j < n && phase < 5; j++){
        nowCount += w[j];
        if(nowCount == tank[phase]){
          nowCount = 0;
          phase++;
        }
        else if(nowCount > tank[phase]){ break; }
      }

      if(phase == 5){
        cout << i + 1 << endl;
        break;
      }
    }
  }

  return 0;
}