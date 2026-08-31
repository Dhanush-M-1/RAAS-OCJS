#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;
int N,Q;

int calc(int i,int n){
    int num = 0;
    if(n<10){
        return i;
    }else{
        int ten = 10;
        while(ten<= n){
            int temp = (n/ten) * (n%ten);
            if (num<temp)num=temp;
            ten *= 10;
        }
    }
    return calc(i+1,num);
}

int main(){

    cin >>Q ;
    for (int i=0;i<Q;i++){
        cin >> N;
        int ans = calc(0,N);
        cout << ans <<endl;
    }
}
