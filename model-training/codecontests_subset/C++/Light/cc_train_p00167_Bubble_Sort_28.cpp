#include <stdio.h>
const int N=1e3+10;
void swap(int &a,int &b){
    int temp=a;
    a=b;
    b=temp;
    return ;
}
int main(){
    int n,t,a[N];
    while(true){
        scanf("%d",&n);
        if(n==0)return 0;
        t=0;
        for(int i=0;i<n;i++)scanf("%d",&a[i]);
        for(int i=0;i<n;i++)for(int j=0;j<n-1;j++){
            if(a[j]>a[j+1]){
                swap(a[j],a[j+1]);
                t++;
            }
        }
        printf("%d\n",t);
    }
}
