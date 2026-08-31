#include <iostream>
#include <cmath>
#include <unordered_set>
using namespace std;


int main(){
    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        unordered_set<int> hold;
        int x,max;
        bool flag=true;
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
            if(!(hold.insert(x).second)){
                flag=false;
                break;
            }
        }
        if(flag){
            cout << hold.size() << endl;
        }else{
            cout << -1 << endl;
        }
    }
    return 0;
}