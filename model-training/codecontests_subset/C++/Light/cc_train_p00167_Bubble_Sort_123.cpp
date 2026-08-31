#include<cstdio>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int main(){
    int n;
    while(cin>>n,n){
        int num[10000]={0},cnt=0;
        num[n]=11000000;
        for(int i=0;i<n;i++)cin>>num[i];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(num[j]>num[j+1]){
                    swap(num[j],num[j+1]);
                    cnt++;
                }
            }
        }
        cout<<cnt<<endl;
    }
    return 0;
}