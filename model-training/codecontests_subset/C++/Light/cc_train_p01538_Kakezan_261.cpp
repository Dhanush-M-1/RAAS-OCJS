#include<stdio.h>
#include<math.h>
int ketasuu(int n){
    for(int i=6;i>=0;i--){
        if((int)n/pow(10,i)>=1) return i+1;
    }
    return -1;
}
int divide(int n,int m){
    return (int)(n/pow(10,m+1))*(int)(n%(int)pow(10,m+1));
}
int main(){
    int q;
    scanf("%d",&q);
    for(int i=0;i<q;i++){
        int count=0,newn,n;
        scanf("%d",&n);
        while(ketasuu(n)>=2){
            newn=0;
            int l=ketasuu(n);
            for(int j=0;j<l-1;j++){
                if(newn<divide(n,j)) newn=divide(n,j);
            }
            n=newn;
            count++;
        }
        printf("%d\n",count);
    }
}