#include <stdio.h>
int main (void){
    int a,c,i,j,n;
    for(;;){
        scanf("%d",&n);
        if(n==0)break;
        int b[101]={},ans=0;
        for(i=0;i<n;i++){
            scanf("%d",&a);
            b[i]=a;
        }
        for(i=1;i<n;i++){
            for(j=1;j<n;j++){
                if(b[j-1]>=b[j]){
                    if(b[j-1]>b[j]){
                        ans++;
                    }
                    c=b[j-1];
                    b[j-1]=b[j];
                    b[j]=c;
                }
            }
        }
        printf("%d\n",ans);
    }
return 0;
}