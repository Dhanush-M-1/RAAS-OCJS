#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
  int N;
  while (cin>>N, N) {
    vector<string> s(N);
    int num[] = {5, 7, 5, 7, 7};
    for (int i=0; i<N; i++) cin>>s[i];
    
    
    for (int i=0; i<N; i++) {
      bool ok=true;
      int idx=i;

      for (int j=0; j<5; j++) {
        int len = s[idx].size();
        ++idx;
        while (idx<N && len<num[j]) len+=s[idx++].size();

        if(idx > N) {
          ok = false;
          break;
        }
        
        if (len != num[j]) {
          ok=false;
        }
      }

      if (ok) {
        cout << i+1 << endl;
        break;
      }
    }
  }
}