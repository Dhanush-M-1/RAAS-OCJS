#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        int x,max,cnt=0;
        cin >> x;
        while(x>=10){
            max=0;
            for(int j=10; j<x; j*=10){
                int val = x/j * (x%j);
                if(val > max){
                    max = val;
                }
            }
            x=max;
            cnt++;
        }
        cout << cnt << endl;
    }
    return 0;
}