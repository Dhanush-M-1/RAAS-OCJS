#include <iostream>
#include <vector>
using namespace std;

int main(){
    while(1){
        int n;
        cin >> n;
        if(n==0) break;

        vector<string> str(n);
        for(int i=0; i<n; i++){
            cin >> str[i];
        }

        for(int i=0; i<n; i++){
            int sp[5] = {5,7,5,7,7};
            int now = 0;
            for(int j=0; j<n; j++){
                sp[now] -= str[i+j].length();
                if(sp[now]<0) break;
                if(sp[now]==0) now++;
                if(now==5){
                    cout << i+1 << endl;
                    i=1e9;
                    break;
                }
            }
        }
    }   
    return 0;
}