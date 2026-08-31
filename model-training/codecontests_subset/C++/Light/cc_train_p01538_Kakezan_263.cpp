#include <iostream>
#include <cstdio>
#include <algorithm> 
#define MAX(a,b) a>b?a:b
#define rep(i,n) for(int i = 0;i < n;i++)
using namespace std;

int main(){
    int Q;
    int N;
    scanf("%d",&Q);
    rep(i,Q){
        int count = 0;
        scanf("%d",&N);
        while(N>=10){
            int temp = N;
            int digit = 0;
            while(temp>0){
                digit++;
                temp/=10;
            }
            count++;
            temp = 10;
            int max = 0;
            rep(i,digit-1){
                max = MAX(max,(N/temp)*(N%temp));
                temp*=10;
            }
            N = max;
        }
        printf("%d\n",count);
    }
    return 0;
}