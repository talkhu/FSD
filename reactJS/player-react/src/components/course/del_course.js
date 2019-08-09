import React from 'react';
import {Dialog, Button} from 'element-react'
import 'element-theme-default'

function ConfirmDeleteDilaog(props) {
  return (
    <div>
      <Dialog
        title="Confirm Delete"
        visible={props.show}
        onCancel={() => { props.onHide() }}
      >
        <Dialog.Body>
          <span>Are you confirm to delete this record?</span>
        </Dialog.Body>

        <Dialog.Footer className="dialog-footer">
          <Button onClick={() => { props.onHide() }}>Cancle</Button>
          <Button type="primary" onClick={ () => { props.onHide('delete'); } }>Confirm</Button>
        </Dialog.Footer>
      </Dialog>
    </div>
  );
}
export default ConfirmDeleteDilaog;
