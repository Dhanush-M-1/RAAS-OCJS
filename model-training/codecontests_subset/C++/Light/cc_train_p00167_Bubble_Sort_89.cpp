#include<iostream>
#include<algorithm>
using namespace std;

int a[1000005];
int main(){
    int n;
    while(cin>>n,n){
        for(int i = 0;i < n;i++)cin>>a[i];
        int cnt = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n-i-1;j++){
                if(a[j]>a[j+1]){
                    swap(a[j],a[j+1]);
                    cnt++;
                }
            }
        }
        cout<<cnt<<endl;
    }
}